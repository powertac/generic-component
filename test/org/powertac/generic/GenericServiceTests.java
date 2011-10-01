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

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powertac.common.repo.PluginConfigRepo;
import org.powertac.common.repo.TimeslotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests for GenericService
 * @author John Collins
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:test/test-config.xml"})
public class GenericServiceTests
{
  @Autowired
  private GenericService service;
  
  @Autowired
  private GenericInitializationService genericInitializationService;
  
  @Autowired
  private PluginConfigRepo pluginConfigRepo;
  
  @Autowired
  private TimeslotRepo timeslotRepo;

  @BeforeClass
  public static void setUpBeforeClass () throws Exception
  {
  }

  @Before
  public void setUp () throws Exception
  {
  }

  @Test
  public void testGenericService ()
  {
    fail("Not yet implemented");
  }

  @Test
  public void testInit ()
  {
    fail("Not yet implemented");
  }

  @Test
  public void testActivate ()
  {
    fail("Not yet implemented");
  }

  @Test
  public void testReceiveMessage ()
  {
    fail("Not yet implemented");
  }

}
