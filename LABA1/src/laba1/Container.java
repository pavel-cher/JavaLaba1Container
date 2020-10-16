package laba1;

/**
 * Класс содержит поля элемента контейнера. Контейнер реализован методом связного списка.
 * @author User
 *
 */

class ContainerElement {
	ContainerElement next;
	int data;
}


/**
 * Класс содержит методы контейнера.
 * @author User
 *
 */
public class Container {
	/**
	 * Начало контейнера*
	 */
	public ContainerElement head;
	/**
	 * Конец контейнера*
	 */
	public ContainerElement tail;
	
	
//////////////////ADD//////////////////
	
	/**
	 * Данный метод позволяет добавлять элемент в начало контейнера
	 * @param data Значение добавляемого элемента
	 */
	public void addFront(int data) {
		ContainerElement x = new ContainerElement();
		x.data = data;
		if(head == null) {
			head = x;
			tail = x;
		}
		else {
			x.next = head;
			head = x;
		}
	}
	/**
	 * Данный метод позволяет добавлять элемент в конец контейнера
	 * @param data Значение добавляемого элемента
	 */
	public void addBack(int data) {
		ContainerElement x = new ContainerElement();
		x.data = data;
		if(tail == null) {
			head = x;
			tail = x;
		}
		else {
			tail.next = x;
			tail = x;
		}
	}
	
	/**
	 * Данный метод позволяет добавлять элемент в контейнер после указанного
	 * @param data Значение добавляемого элемента
	 * @param value Указанный элемент
	 */
	public void addAfter(int data,int value) {
		if(head == null) {       
			ContainerElement x = new ContainerElement(); 
			x.data = value;
			head = x;
			tail = x;
            return;
		}

        if (head == tail) {    
        	ContainerElement x = new ContainerElement();
    		x.data = value;
    		tail.next = x;
			tail = x;
            return;            
        }
        
        ContainerElement buf = head;
        while (buf.next != null) {    
            if (buf.next.data == data) {  
                if(tail == buf.next)      
                {
                	ContainerElement x = new ContainerElement(); 
                	x.data = value;
                	tail.next = x;
                	tail = x;
                	return;
                }
                ContainerElement x = new ContainerElement();
        		x.data = value;
        		x.next = buf.next.next;
        		buf.next.next = x;
                return;                 
            }
            buf = buf.next;                
        }
	}
	
	/**
	 * Данный метод позволяет добавлять элемент в контейнер перед указанным
	 * @param data Значение добавляемого элемента
	 * @param value Указанный элемент
	 */
	public void addBefore(int data,int value) {
		if(head == null) {       
			ContainerElement x = new ContainerElement(); 
			x.data = value;
			head = x;
			tail = x;
            return;
		}

        if (head == tail) {    
        	ContainerElement x = new ContainerElement();
    		x.data = value;
    		x.next = head;
			head = x;
            return;            
        }
        
        ContainerElement buf = head;
        
        if (buf.data == data) {
        	ContainerElement x = new ContainerElement(); 
        	x.data = value;
        	x.next = head;
        	head = x;
        	return;
        }
        
        while (buf.next != null) {    
            if (buf.next.data == data) {  
                if(tail == buf.next)      
                {
                	ContainerElement x = new ContainerElement(); 
                	x.data = value;
                	buf.next = x;
                	x.next = tail;
                	return;
                }
                ContainerElement x = new ContainerElement();
        		x.data = value;
        		x.next = buf.next;
        		buf.next = x;
                return;              
            }
            buf = buf.next;                
        }
	}
	
//////////////////DELETE/////////////////
	/**
	 * Данный метод позволяет удалять начальный элемент контейнера
	 */
	public void deleteFront() {
		if(head == null) {       
            System.out.println("Нечего удалять, контейнер пуст.");
            return;
		}
		head = head.next;
	}
	/**
	 * Данный метод позволяет удалять конечный элемент контейнера
	 */
	public void deleteBack() {
		if(head == null) {        
            System.out.println("Нечего удалять, контейнер пуст.");
            return;
		}
		ContainerElement buf = this.head;
		while(buf.next != tail) {
			buf = buf.next;
		}
		tail = buf;
		buf.next = null;
	}
	/**
	 * Данный метод позволяет удалять указанный элемент контейнера
	 * @param data Указанный элемент
	 */
	public void delEl(int data)          
    {
        if(head == null) {      
        	System.out.println("Нечего удалять, контейнер пуст.");
            return;      
        }
        if (head == tail) {     
            head = null;        
            tail = null;
            return;             
        }

        if (head.data == data) {    
            head = head.next;       
            return;                 
        }

        ContainerElement buf = head;       
        while (buf.next != null) {    
            if (buf.next.data == data) {  
                if(tail == buf.next)      
                {
                    tail = buf;           
                }
                buf.next = buf.next.next;   
                return;                 
            }
            buf = buf.next;                
        }
    }

//////////////////GET//////////////////	
	/**
	 * Данный метод позволяет получить адрес указанного элемента
	 * @param data Указанный элемент
	 * @return Возвращает адрес элемента
	 */
	public ContainerElement getAdrByValue(int data)
	{
		if (head == null)
			return null;
		if (head==tail)
			return head;
		ContainerElement buf = head;       
		while (buf.next != null) {    
            if (buf.next.data == data) {  
                if(tail == buf.next)      
                {
                    return tail;           
                }
                return buf.next;                 
            }
            buf = buf.next;                
        }
		return null;				
	}
	
//////////////////PRINT////////////////
    /**
     * Данный метод позволяет вывести контейнер в консоль
     */
	public void printContainer() {
		if(head == null) {      
        	System.out.println("Контейнер пуст.");
            return;      
        }
		ContainerElement buf = this.head;
		while(buf != null) {
			System.out.print(buf.data + " ");
			buf = buf.next;
		}
		System.out.println();
	}

}


/**
 * Класс для проверки работоспособности методов контейнера
 * @author User
 *
 */
class TestContainer {
	
	public static void main(String args[])
	{
		Container c = new Container();
		c.printContainer();
		for(int i = 0; i<10; i++) {
            c.addBack(i);
        }
        c.printContainer();
        c.deleteBack();
        c.printContainer();
        c.delEl(2);
        c.printContainer();
        c.addBefore(0,6);
        c.printContainer();
        c.addAfter(0,7);
        c.printContainer();
        c.getAdrByValue(6);
     
	}
}


