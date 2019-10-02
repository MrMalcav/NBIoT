package NBIoT.repositories;

public interface RepositoryFactory {

    CounterRepository getCounterRepositories();

    DiagnosticRepository getDiagnosticRepositories();

    PulseCounterRepository getPulseCounterRepositories();

    DiagnosticPulseCounterRepository getDiagnosticPulseCounters();

    ConfigurationRepository getConfigurationRepository();
}
