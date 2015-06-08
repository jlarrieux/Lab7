//--------------------------------------------------------------------
//
//  Laboratory 7                                         SList.jshl
//
//  Class definitions for the singly linked list implementation of 
//  the List ADT
//
//  The student is to complete all missing or incomplete method 
//     implementations for each class (Slist and SListNode)
//
//--------------------------------------------------------------------



class SList implements List {


    // Data members
    private SListNode head,     // Reference to the beginning of the list
            cursor; // Reference to current cursor position


    // Constructors & Helper Method
    SList()                  // Default constructor: Creates an empty list
    {
        setup();
    }


    SList(int size)
    // Creates an empty list. The argument is included for compatibility
    // with the array implementation; size is ignored.
    {
        setup();
    }


    // Class Methods
    private void setup()   // Called by constructors only: Creates an empty list
    {
        head = null;
        cursor = null;
    }


    // ----- Insert method definitions for the interface List here ------ //
    @Override
    public void insert(Object newElement) {
        if(newElement == null) System.out.printf("Attempting to insert a null element!\n");
        else {
            if(head==null){
                head = new SListNode(newElement, null);
                cursor=head;
            }
            else {
                SListNode toInsert = new SListNode(newElement, cursor.getNext());
                cursor.setNext(toInsert);
                cursor = toInsert;
            }
        }
    }


    @Override
    public void remove() {
        if(isEmpty()) System.out.println("Attempting to remove elements from an empty list");
        else if(cursor==head){
            head = cursor.getNext();
            gotoNext();
        }
        else{
            if(cursor.getNext()!=null) {
                if (gotoPrior()) {
                    cursor.setNext(cursor.getNext().getNext());
                    gotoNext();
                } else System.out.printf("Remove operation failed!\n");
            }
            else{
                if(gotoPrior()){
                    cursor.setNext(null);
                    cursor = head;

                }
                else System.out.printf("Remove operation failed!\n");
            }
        }
    }


    @Override
    public void replace(Object newElement) {
        if(isEmpty()) System.out.println("Attempting to replace element from an empty list!");
        else if(cursor==head){
            head.setElement(newElement);
        }
        else{
            SListNode sl = new SListNode(newElement,cursor.getNext());
            if(gotoPrior()){
                cursor.setNext(sl);
                cursor = sl;
            }
            else System.out.printf("Replace operation failed!\n");
        }

    }


    @Override
    public void clear() {
        head=null;
        cursor=null;
    }


    @Override
    public boolean isEmpty() {
        if(head==null) return true;
        else return false;
    }


    @Override
    public boolean isFull() {
        return false;
    }


    @Override
    public boolean gotoBeginning() {
        if(isEmpty())  return false;
        else {
            cursor = head;
            return true;
        }
    }


    @Override
    public boolean gotoEnd() {
        SListNode sl = cursor;
        if(isEmpty()) return false;
        else {
            while(sl.getNext()!=null){
                sl =sl.getNext();
            }
            cursor = sl;
            return true;
        }
    }




    @Override
    public boolean gotoNext() {
        if(cursor.getNext()== null)  return false;
        else{
            cursor = cursor.getNext();
            return true;
        }
    }


    @Override
    public boolean gotoPrior() {
       if(cursor==head) return false;
        else {
           SListNode sl = head;
           while ((sl.getNext()!=cursor)){
               sl = sl.getNext();
           }
           cursor = sl;
           return true;
       }
    }


    @Override
    public Object getCursor() {
        return cursor.getElement();
    }


    @Override
    public void showStructure() {
        int j=0;
        if(head==null) System.out.println("Empty list!");

        else {
            System.out.println("SHOWING STRUCTURE");
            System.out.printf("HEAD\t");
            SListNode sl = new SListNode(head.getElement(),head.getNext());
            do{
                System.out.printf("%s\t", String.valueOf(sl.getElement()));
                j++;
                sl = sl.getNext();
                if(j>10)break;
            }while(sl!=null );

            System.out.printf("\tEND\nCurrent cursor value: %s\n", String.valueOf(cursor.getElement()));


        }

    }


    //--------------------------------------------------------------------
    //
    //                        In-lab operations
    //
    //--------------------------------------------------------------------


    void moveToBeginning()                    // Move to beginning
    {
        if(isEmpty()) System.out.println("Attempting to move elements in an empty list!");
        else if (cursor!=head){
            SListNode follow;

            if(cursor.getNext()==null) follow = head;
            else follow = cursor.getNext();
            SListNode currentToMove = new SListNode(cursor.getElement(), follow);
//            if(cursor.getNext()==null){
//

                if(gotoPrior()) {
                    cursor.setNext(null);
                }

                head = currentToMove;
//            }
//            else {
//
//            }


        }
    }


    void insertBefore(Object newElement)     // Insert before cursor
    {

    }



} // class SList