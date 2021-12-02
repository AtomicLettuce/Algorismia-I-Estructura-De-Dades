package Practica1;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class lecturaJRB extends JDialog {

    // Variable que apunta a quin dels JRB està sel·leccionat
    int seleccionat;

    // Mètode Construcor, l'String str representa una pregunta que es fa a l'usuari
    // l'String[] representa el nom de cada opció que tendrà cada JRadioButton
    public lecturaJRB(JFrame frame, String str, String[] missatge) {
        super(frame, true);
        setTitle("LECTURA RadioButton");

        // Ens guardam el panel de continguts
        Container panelContenidos = getContentPane();

        // Assignam layout de 3 files i una columna
        panelContenidos.setLayout(new GridLayout(2+missatge.length, 1));

        // Cream una estiqueta que contindrà el text passat per paràmetre
        JLabel etq = new JLabel(str);
        add(etq);

        // Cream un array de JRB de tantes posicions com se'ns ha indicat
        JRadioButton jrb[]=new JRadioButton[missatge.length];
        // Cream un BG per tal de que només hi pugui haver un botó sel·leccionat alhora
        ButtonGroup bg = new ButtonGroup();
        for(int i=0;i<missatge.length;i++){
            jrb[i]=new JRadioButton(missatge[i]);
            bg.add(jrb[i]);
            add(jrb[i]);
        }
        // Deixam el primer sel·leccionat per evitar possibles problemes
        jrb[0].setSelected(true);
        
        // Cream un JButton per confirmar la sortida
        JButton jbC = new JButton("CONFIRMAR");
        panelContenidos.add(jbC);
        // Assignació i definició del seu gestor d'events
        jbC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Canviam el valor de la variable de retorn depenent de quin botó estigui pitjat
                for(int i=0;i<jrb.length;i++){
                    if(jrb[i].isSelected()){
                        seleccionat=i;
                    }
                }
                // posam a FALSE la visibilitat del Jdialog lo que resulta en tancar el JDialog
                setVisible(false);
            }
        });
        // Dimensionam el JDialog
        setSize(300, jrb.length * 75);
        // El centram dins de la finestra principal
        setLocationRelativeTo(frame);
        // el feim visible
        setVisible(true);
    }
    
    // Mètode que retorna quin dels botons s'ha pitjat
    public int getSeleccionat(){
        return seleccionat;
    }

}
