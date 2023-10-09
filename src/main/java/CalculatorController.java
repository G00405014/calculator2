@RestController
public class CalculatorController {



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
