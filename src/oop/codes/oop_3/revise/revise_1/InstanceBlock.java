package src.oop.oop_3.revise.revise_1;
// https://www.javatpoint.com/instance-initializer-block
class InstanceBlock {
    int speed;  
      
    InstanceBlock(){
        // here super() nahi hai fir bi pehle super hi run hoga by default
        System.out.println("constructor is invoked");
    }

   
//    {System.out.println("instance initializer block invoked");}


    //  The java compiler copies the code of instance initializer block in every constructor.
    public static void main(String[] args){
        // it seems that block runs first but no it goes inside constructor
        // calls the super() and then it calls the block
        // so constructor me jata hai fir block me jata hai
    InstanceBlock b1=new InstanceBlock();
    InstanceBlock b2=new InstanceBlock();
    }      
}  