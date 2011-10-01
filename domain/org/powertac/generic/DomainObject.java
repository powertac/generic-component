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

import org.powertac.common.IdGenerator;
import org.powertac.common.state.Domain;
import org.powertac.common.state.StateChange;

/**
 * Example domain object type. In the server, these are not mapped to a
 * relational data model. If you need to implement queries on one or more
 * related domain types, consider building a Repo, and using it as a
 * factory/finder to create and query for them. Note that domain types
 * cannot in general have their dependencies autowired, because autowiring
 * works only for types that are created by Spring. Most of those are 
 * singletons. If you need dependencies on services, then you will need to
 * look them up using {@link org.powertac.common.spring.SpringApplicationContext}.
 * <p>
 * Most service components do not have domain types, and domain types that
 * are not in common cannot be shared with other components or with brokers.
 * @author John Collins
 */
@Domain // causes calls to the constructor to be logged
public class DomainObject
{
  // id values are standardized
  private long id = IdGenerator.createId();

  private String attribute;
  
  public DomainObject (String attribute)
  {
    super();
    this.attribute = attribute;
  }
  
  /** Returns instance id. Needed to support state logging */
  public long getId()
  {
    return id;
  }
  
  public String getAttribute ()
  {
    return attribute;
  }
  
  @StateChange // causes calls to this setter method to be logged
  public void setAttribute (String newValue)
  {
    attribute = newValue;
  }
  
  /** Useful for trace logging */
  public String toString ()
  {
    return ("DomainObject " + id + ": " + attribute);
  }
}
