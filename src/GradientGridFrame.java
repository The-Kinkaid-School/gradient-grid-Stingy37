import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradientGridFrame extends JFrame implements ActionListener
{
    private GradientGridPanel mainPanel;

    // TODO: pick better (and more?) names than this.
    private String[] modeNames = {"Good Example", "Bad Example", "Another Bad Example", "Vertical Snake", "Horizontal Snake", "Spiral"};

    private JComboBox modePopup;
    private JLabel stateLabel;


    public GradientGridFrame()
    {
        super("Gradient Grid!");
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        getContentPane().setLayout(new BorderLayout());
        // add graphics panel in center
        mainPanel = new GradientGridPanel();
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        // add popup menu at top
        modePopup = new JComboBox(modeNames);
        getContentPane().add(modePopup, BorderLayout.NORTH);
        modePopup.addActionListener(this);
        // add state label at bottom
        stateLabel = new JLabel();
        stateLabel.setHorizontalAlignment(JLabel.CENTER);
        getContentPane().add(stateLabel,BorderLayout.SOUTH);
        updateStateLabel();
    }

    /**
     * respond if the user has changed the selection in the popup menu (JComboBox)
     * @param actEvt the event to be processed, describing what the user did.
     */
    public void actionPerformed(ActionEvent actEvt)
    {
        if (actEvt.getSource() == modePopup)
        {
            int choice = modePopup.getSelectedIndex();
            mainPanel.setMode(choice);
            updateStateLabel();
        }
    }

    /**
     * update the state label, based on whether the main panel has met the criteria.
     */
    public void updateStateLabel()
    {
        if (mainPanel.confirmGridMeetsSpecifications())
        {
            stateLabel.setText("Meets Specifications.");
            stateLabel.setForeground(new Color(0, 128, 0));
        }
        else
        {
            stateLabel.setText("Does not meet Specifications.");
            stateLabel.setForeground(new Color(192,0,0));
        }
    }
}
