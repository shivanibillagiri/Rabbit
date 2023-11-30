package rabbitApp;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rabbit")
public class RabbitController {

 private int lengthOfHolesArray = 100;
 private int positionOfRabbit = (int) (Math.random() * lengthOfHolesArray);

 @GetMapping("/start")
 public String startGame() {
     positionOfRabbit = (int) (Math.random() * lengthOfHolesArray);
     return "Game started! Rabbit is hiding in one of the holes.";
 }

 @PostMapping("/check")
 public String checkForRabbit(@RequestParam int guess) {
     if (guess == positionOfRabbit) {
         return "Congratulations! You found the rabbit at " + guess + "!";
     } else {
         randomHop();
         return "You did not find the rabbit. Rabbit hopped to " + positionOfRabbit + ".";
     }
 }

 private void randomHop() {
     if (Math.random() > 0.5) {
         positionOfRabbit++;
     } else {
         positionOfRabbit--;
     }
     positionOfRabbit = Math.min(positionOfRabbit, lengthOfHolesArray - 1);
     positionOfRabbit = Math.max(0, positionOfRabbit);
 }
}
