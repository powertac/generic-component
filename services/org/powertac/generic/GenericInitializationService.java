/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an
 * "AS IS" BASIS,  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.powertac.generic;

import java.util.List;

import org.apache.log4j.Logger;
import org.powertac.common.Competition;
import org.powertac.common.PluginConfig;
import org.powertac.common.interfaces.InitializationService;
import org.powertac.common.repo.PluginConfigRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Here we support the pre-game and start-of-game behaviors driven by the
 * CompetitionControlService. This class is instantiated by Spring, so in
 * general the constructor can be omitted.
 * @author John Collins
 */
@Service
public class GenericInitializationService
implements InitializationService
{
  static private Logger log = Logger.getLogger(GenericInitializationService.class.getName());

  @Autowired
  private GenericService genericService;
  
  @Autowired
  private PluginConfigRepo pluginConfigRepo;
  
  /**
   * Called during pre-game to set game defaults. In this example the default
   * value of the parameter is hard-coded, but in general it would make sense
   * to take it from a config file. The result is a PluginConfig instance that
   * can be viewed and modified through the web interface before a game is
   * started.
   */
  public void setDefaults ()
  {
    int parameter = 42;
    pluginConfigRepo.makePluginConfig("Generic", "init")
      .addConfiguration("parameter", Integer.toString(parameter));
  }

  /**
   * Called during game startup to set initial conditions for GenericService.
   * The order of initializations can be controlled by looking at the list of
   * completedInits. If the preconditions are met, then performs initialization
   * and returns its name "Generic". If there is a problem that should prevent
   * the game from starting, then returns the string "fail". Otherwise returns
   * null, in which case the CompetitionControlService will call again after
   * other initializations are completed.
   */
  public String initialize (Competition competition, List<String> completedInits)
  {
    if (!completedInits.contains("Other")) {
      log.debug("waiting for Other to initialize");
      return null;
    }
    PluginConfig config = pluginConfigRepo.findByRoleName("Generic");
    if (config == null) {
      log.error("PluginConfig for Generic does not exist.");
      return "fail";
    }
    genericService.init(config);
    return "Generic";
  }
}
