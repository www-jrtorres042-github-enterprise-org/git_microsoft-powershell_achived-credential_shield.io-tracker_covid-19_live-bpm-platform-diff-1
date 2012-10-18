package com.camunda.fox.cycle.connector;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;


/**
 * The actual cache for instantiated connectors.
 * 
 * This object is a +session scoped+ bean and thus is valid per user. 
 * 
 * @author nico.rehwaldt
 */
@Component
@Scope(
  value = WebApplicationContext.SCOPE_SESSION, 
  proxyMode = ScopedProxyMode.TARGET_CLASS
)
public class ConnectorCache {

  /**
   * the internal cache
   */
  private Map<Long, Connector> cache = new HashMap<Long, Connector>();

  public boolean contains(long id) {
    return cache.containsKey(id);
  }
  
  public Connector remove(long id) {
    Connector oldConnector = cache.remove(id);
    if (oldConnector != null) {
      oldConnector.dispose();
    }
    return oldConnector;
  }

  public Connector get(long id) {
    return cache.get(id);
  }

  public Connector put(long id, Connector connector) {
    Connector oldConnector = cache.put(id, connector);

    if (oldConnector != null) {
      oldConnector.dispose();
    }

    return oldConnector;
  }

  public Collection<Connector> values() {
    return cache.values();
  }
  
  @PreDestroy
  public void dispose() {
    for (Connector c: cache.values()) {
      c.dispose();
    }
    
    cache = new HashMap<Long, Connector>();
  }
}
