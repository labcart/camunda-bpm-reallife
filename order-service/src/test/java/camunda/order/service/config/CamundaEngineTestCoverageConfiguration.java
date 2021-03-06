package camunda.order.service.config;

import org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration;
import org.camunda.bpm.extension.process_test_coverage.junit.rules.ProcessCoverageConfigurator;
import org.camunda.bpm.spring.boot.starter.configuration.impl.AbstractCamundaConfiguration;
import org.springframework.boot.test.context.TestConfiguration;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@TestConfiguration
public class CamundaEngineTestCoverageConfiguration extends AbstractCamundaConfiguration {

    @Override
    public void preInit(SpringProcessEngineConfiguration configuration) {
        ProcessCoverageConfigurator.initializeProcessCoverageExtensions(configuration);
    }
}