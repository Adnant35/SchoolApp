package tr.com.kolaysoft.school.web.rest.errors;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class BadRequestAlertException extends AbstractThrowableProblem {

    public BadRequestAlertException(String defaultMessage) {
        super(null, defaultMessage, Status.BAD_REQUEST);
    }
}
