/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryFunctions;

public class stack {
    private String[] stack;
    private int maxSize;
    private int current;
    

    public String[] getStack() {
        return stack;
    }

    public void setStack(String[] stack) {
        this.stack = stack;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    

    public stack(String[] stack, int maxSize, int current) {
        this.stack = stack;
        this.maxSize = maxSize;
        this.current = current;
       
    }
    
    public static boolean isStackFull(stack Stack){
        boolean full = false;
        if (Stack.getCurrent() == Stack.getStack().length-1){
            full = true;
        }
        return full;
    }
    
    public static boolean isStackEmpty(stack Stack){
        boolean empty = false;
        if (Stack.getCurrent() == -1){
            empty = true;
        }
        return empty;
    }
    
    public static void addElement(stack Stack, String nextPage){
        
        boolean full = isStackFull(Stack);
        if(full){
            
        } else{
            
            Stack.setCurrent(Stack.getCurrent()+1);
            
            //Stack.getStack().
        }
    }
    
    public static void removeElement(stack Stack){
        
        boolean empty = isStackEmpty(Stack);
        if(empty){          
        } else{                     
            //Stack.setStack([Stack.getCurrent()] = null);
            Stack.setCurrent(Stack.getCurrent()-1);            
        }
        
    }
    public static String getTopElement(stack Stack){
        
        boolean empty = isStackEmpty(Stack);
        String previousPage = null;
        if(empty){
            return null;
        }
        else{
            previousPage = Stack.getStack()[Stack.getCurrent()];
        }
        return previousPage;
    }
}
