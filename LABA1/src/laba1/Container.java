package laba1;

/**
 * ����� �������� ���� �������� ����������. ��������� ���������� ������� �������� ������.
 * @author User
 *
 */

class ContainerElement {
	ContainerElement next;
	int data;
}


/**
 * ����� �������� ������ ����������.
 * @author User
 *
 */
public class Container {
	/**
	 * ������ ����������*
	 */
	public ContainerElement head;
	/**
	 * ����� ����������*
	 */
	public ContainerElement tail;
	
	
//////////////////ADD//////////////////
	
	/**
	 * ������ ����� ��������� ��������� ������� � ������ ����������
	 * @param data �������� ������������ ��������
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
	 * ������ ����� ��������� ��������� ������� � ����� ����������
	 * @param data �������� ������������ ��������
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
	 * ������ ����� ��������� ��������� ������� � ��������� ����� ����������
	 * @param data �������� ������������ ��������
	 * @param value ��������� �������
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
	 * ������ ����� ��������� ��������� ������� � ��������� ����� ���������
	 * @param data �������� ������������ ��������
	 * @param value ��������� �������
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
	 * ������ ����� ��������� ������� ��������� ������� ����������
	 */
	public void deleteFront() {
		if(head == null) {       
            System.out.println("������ �������, ��������� ����.");
            return;
		}
		head = head.next;
	}
	/**
	 * ������ ����� ��������� ������� �������� ������� ����������
	 */
	public void deleteBack() {
		if(head == null) {        
            System.out.println("������ �������, ��������� ����.");
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
	 * ������ ����� ��������� ������� ��������� ������� ����������
	 * @param data ��������� �������
	 */
	public void delEl(int data)          
    {
        if(head == null) {      
        	System.out.println("������ �������, ��������� ����.");
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
	 * ������ ����� ��������� �������� ����� ���������� ��������
	 * @param data ��������� �������
	 * @return ���������� ����� ��������
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
     * ������ ����� ��������� ������� ��������� � �������
     */
	public void printContainer() {
		if(head == null) {      
        	System.out.println("��������� ����.");
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
 * ����� ��� �������� ����������������� ������� ����������
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


