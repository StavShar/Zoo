
 /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    # ceateAction (maybe better send to constructors all parameters and the constructor will check validation

    # change all set flag to do while loop - dont show error just return false

    # round for 2 dits after floating point (setWeight)

 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  */

 import animals.Bear;
 import animals.Lion;
import animals.Animal;
 import mobility.Point;

 import static zoo.ZooActions.eat;
 import static zoo.ZooActions.move;

 class temp{
     public static void main(String[] args) {
         Animal a = new Lion("Simba");
         Animal b = new Bear("Baloo");
         System.out.println("\n\n\n");
         boolean flag = move(a,new Point(44,55));
         System.out.println(flag);
         System.out.println("\n\n\n");
         flag = move(b,new Point(44,5500));
         System.out.println(flag);
     }
 }