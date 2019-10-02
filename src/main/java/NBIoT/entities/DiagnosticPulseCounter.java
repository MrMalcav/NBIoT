package NBIoT.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class DiagnosticPulseCounter extends PulseCounter{

    @ManyToOne
    private Diagnostic diagnostic;

    public DiagnosticPulseCounter() {}

    public void setDiagnostic(Diagnostic diagnostic) {
        this.diagnostic = diagnostic;
    }

    public Diagnostic getDiagnostic() {
        return diagnostic;
    }
}
