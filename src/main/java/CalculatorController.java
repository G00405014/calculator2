import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    public static class Response {
        private String operation;
        private double total;

        public String getOperation() {
            return operation;
        }

        public void setOperation(String operation) {
            this.operation = operation;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }
    }

    @GetMapping("/calculate/{num1}/{num2}/{operation}")
    public Response calculate(
            @PathVariable double num1,
            @PathVariable double num2,
            @PathVariable String operation) {

        double result = 0;
        switch (operation.toLowerCase()) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":  // Corrected from "multiple" to "multiply"
                result = num1 * num2;
                break;
            case "divide":  // Corrected from "divide" to "divide"
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }

        Response response = new Response();
        response.setOperation(operation.toLowerCase());
        response.setTotal(result);

        return response;
    }
}
