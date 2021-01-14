import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Work extends JPanel{

    String[][] array = {
            {"A","B","C","B","A"},
            {"B","B","C","B","B"},
            {"C","C","C","C","C"},
            {"B","B","C","B","B"},
            {"A","B","C","B","A"}
    };
    int padding = 25;

    /**
     *Метод, който създава обектите
     * и показва на кое място ще са на дъската чрез масив
     * @param g
     */
    public void paint(Graphics g){
        Guard gard_yellow  = new Guard("guard", 1 );
        Guard gard_green  = new Guard("guard",  2 );
        Leader leader_yellow  = new Leader("leader",  1 );
        Leader leader_green  = new Leader("leader",  2 );
        Avatar[][] array_model =
                {
                        {gard_yellow ,gard_yellow,gard_yellow,gard_yellow,leader_yellow},
                        {null,null,null,null,null},
                        {null,null,null,null,null},
                        {null,null,null,null,null},
                        {leader_green,gard_green,gard_green,gard_green,gard_green}

                };
        AddElements(g, array_model);
    }

    /**
     * Метод, който прибавя квадратчетата на дъската,
     * в съответните им цветове
     * @param g
     * @param array_model
     */

    private void AddElements(Graphics g, Avatar[][] array_model) {
        int x = 0 ;
        int y = 0;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){

                if (array[i][j] == "A")
                {
                    g.setColor(Color.red);
                }
                else if (array[i][j] == "B") {
                    if (array_model[i][j] != null) {
                        g.setColor(Color.BLACK);
                    } else {
                        g.setColor(Color.lightGray);
                    }
                }
                else
                {
                    g.setColor(Color.white);
                }
                g.fillRect(x, y, 100, 100);

                g.setColor(Color.black);
                g.drawRect(x, y, 100, 100);
                AddAvatars(g , array_model , x, y , i , j) ;
                AddCenterElement(g,x,y, i , j );
                x+=100;
            }
            y+= 100;
            x = 0 ;
        }
    }

    /**
     * Метод, който прибавя кръгчето в средата на дъската
     * @param g
     * @param x
     * @param y
     * @param i
     * @param j
     */
    private void AddCenterElement(Graphics g , int x , int y , int i , int j) {
        if (i == j && i == 2) {
            g.setColor(Color.BLACK);
            g.fillOval(x + padding, y + padding, 50, 50);
            g.setColor(Color.gray);
            g.drawOval(x + padding, y + padding, 50, 50);
        }
    }

    /**
     * Метод, който прибавя фигурите върху квадратчетата
     * @param g
     * @param array_model
     * @param x
     * @param y
     * @param i
     * @param j
     */
    private void AddAvatars(Graphics g, Avatar[][] array_model, int x , int  y , int i , int j) {
        if (array_model[i][j] != null)
        {
            if (array_model[i][j].type == 2)
            {
                if (array_model[i][j].team == 1 )
                {
                    g.setColor(Color.yellow);
                }
                else
                {
                    g.setColor(Color.green);
                }
                g.fillOval(x+padding, y+padding, 50, 50);
                if (array_model[i][j].team == 1 )
                {
                    g.setColor(Color.green);
                }
                else
                {
                    g.setColor(Color.yellow);
                }
                g.drawOval(x+padding, y+padding , 50, 50);
            }
            else
            {
                if (array_model[i][j].team == 1 )
                {
                    g.setColor(Color.yellow);
                }
                else
                {
                    g.setColor(Color.green);
                }
                g.fillRect(x+padding, y+padding, 50, 50);
                g.setColor(Color.black);
                g.drawRect(x+padding, y+padding , 50, 50);
            }

        }
    }

    /**
     * Метод, който създава панела, на който ще рисуваме
     */
    public static void Create(){
        JFrame frame = new JFrame();
        frame.setSize(515,530);
        frame.getContentPane().add(new Work());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}