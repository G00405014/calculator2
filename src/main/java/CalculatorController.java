
@RestController
public class CalculatorController {


    public static class Response {
        private String operation;
        private double total;

        // Getters and setters
    }

    //Create the calculate method
    @GetMapping("/calculate")
    public Response calculate(
            @RequestParam double num1,
            @RequestParam double num2,
            @RequestParam String operation) {

        double result = 0;
        switch (operation.toLowerCase()) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
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
