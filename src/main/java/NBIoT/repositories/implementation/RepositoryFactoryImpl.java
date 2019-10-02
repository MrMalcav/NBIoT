package NBIoT.repositories.implementation;

import NBIoT.repositories.*;
import NBIoT.repositories.ConfigurationRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class RepositoryFactoryImpl implements RepositoryFactory {

    @Inject
    private CounterRepository counterRepository;

    @Inject
    private DiagnosticRepository diagnosticRepository;

    @Inject
    private PulseCounterRepository pulseCounterRepository;

    @Inject
    private DiagnosticPulseCounterRepository diagnosticPulseCounterRepository;

    @Inject
    private ConfigurationRepository configurationRepository;



    @Override
    public CounterRepository getCounterRepositories() {
        return counterRepository;
    }

    @Override
    public DiagnosticRepository getDiagnosticRepositories() {
        return diagnosticRepository;
    }

    @Override
    public PulseCounterRepository getPulseCounterRepositories() {
        return pulseCounterRepository;
    }

    @Override
    public DiagnosticPulseCounterRepository getDiagnosticPulseCounters() { return diagnosticPulseCounterRepository; }

    @Override
    public ConfigurationRepository getConfigurationRepository() { return configurationRepository; }
}
