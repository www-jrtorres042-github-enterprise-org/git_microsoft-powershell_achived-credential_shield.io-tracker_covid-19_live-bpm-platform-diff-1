/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.camunda.bpm.dmn.engine;

import java.util.List;

import org.camunda.bpm.dmn.engine.delegate.DmnDecisionTableEvaluationListener;
import org.camunda.bpm.dmn.engine.spi.DmnEngineMetricCollector;
import org.camunda.bpm.dmn.feel.FeelEngine;
import org.camunda.bpm.dmn.feel.FeelEngineFactory;

/**
 * The configuration of a {@link DmnEngine}. It can be used
 * to build a new engine using {@link #buildEngine()}.
 *
 * <p>
 *   Please be aware that changes to the configuration can also
 *   influence the behavior of engines which were already created
 *   by this configuration instance.
 * </p>
 */
public interface DmnEngineConfiguration {

  /**
   * @return the configured engine metric collector
   */
  DmnEngineMetricCollector getEngineMetricCollector();

  /**
   * Set the engine metric collector
   *
   * @param engineMetricCollector the engine metric collector to use
   */
  void setEngineMetricCollector(DmnEngineMetricCollector engineMetricCollector);

  /**
   * Set the engine metric collector
   *
   * @param engineMetricCollector the engine metric collector to use
   * @return this configuration
   */
  DmnEngineConfiguration engineMetricCollector(DmnEngineMetricCollector engineMetricCollector);

  /**
   * @return the list of custom pre decision table evaluation listeners
   */
  List<DmnDecisionTableEvaluationListener> getCustomPreDecisionTableEvaluationListeners();

  /**
   * Set the list of pre decision table evaluation listeners. They will be notified before
   * the default decision table evaluation listeners.
   *
   * @param decisionTableEvaluationListeners the list of pre decision table evaluation listeners
   */
  void setCustomPreDecisionTableEvaluationListeners(List<DmnDecisionTableEvaluationListener> decisionTableEvaluationListeners);

  /**
   * Set the list of pre decision table evaluation listeners. They will be notified before
   * the default decision table evaluation listeners.
   *
   * @param decisionTableEvaluationListeners the list of pre decision table evaluation listeners
   * @return this configuration
   */
  DmnEngineConfiguration customPreDecisionTableEvaluationListeners(List<DmnDecisionTableEvaluationListener> decisionTableEvaluationListeners);

  /**
   * @return the list of custom post decision table evaluation listeners
   */
  List<DmnDecisionTableEvaluationListener> getCustomPostDecisionTableEvaluationListeners();

  /**
   * Set the list of post decision table evaluation listeners. They will be notified after
   * the default decision table evaluation listeners.
   *
   * @param decisionTableEvaluationListeners the list of post decision table evaluation listeners
   */
  void setCustomPostDecisionTableEvaluationListeners(List<DmnDecisionTableEvaluationListener> decisionTableEvaluationListeners);

  /**
   * Set the list of post decision table evaluation listeners. They will be notified after
   * the default decision table evaluation listeners.
   *
   * @param decisionTableEvaluationListeners the list of post decision table evaluation listeners
   * @return this configuration
   */
  DmnEngineConfiguration customPostDecisionTableEvaluationListeners(List<DmnDecisionTableEvaluationListener> decisionTableEvaluationListeners);

  /**
   * Create a {@link DmnEngine} with this configuration
   *
   * @return the created {@link DmnEngine}
   */
  DmnEngine buildEngine();

}
