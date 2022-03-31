
 /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    # (?) chew/roar methods (?)

    # Ilocatable - getLocation and setLocation "never used"

    # ceateAction (maybe better send to constructors all parameters and the constructor will check validation

    # change all set flag to do while loop - set attr until its valid

    # round for 2 dits after floating point (setWeight)

 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  */

 import animals.Bear;
 import animals.Lion;
import animals.Animal;

 import static zoo.ZooActions.eat;

 class temp{
     public static void main(String[] args) {
         Animal a = new Lion("Simba");
         Animal b = new Bear("Baloo");
         System.out.println("\n\n\n");
         boolean flag = eat(a,b);
         System.out.println(flag);
     }
 }