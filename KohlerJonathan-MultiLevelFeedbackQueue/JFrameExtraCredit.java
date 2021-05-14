import javax.swing.table.DefaultTableModel;
/**
 * This is a visual display of the simulation
 * I need the extra credit, cause I'm pretty sure I did horrible on my midterm...
 *
 * @author Jonathan Kohler
 * @version 7/24/2019
 */
public class JFrameExtraCredit extends javax.swing.JFrame 
{
    public javax.swing.JTextArea console;
    public javax.swing.JLabel isBusy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    public javax.swing.JSlider jSlider1;
    public javax.swing.JTable jTable_Queue1;
    public javax.swing.JTable jTable_Queue2;
    public javax.swing.JTable jTable_Queue3;
    public javax.swing.JTable jTable_Queue4;
    public javax.swing.JTable jTable_cpu;
    public javax.swing.JTable jTable_inputQueue;
    public javax.swing.JLabel job;
    public javax.swing.JLabel quantum;
    public javax.swing.JLabel speed;
    public javax.swing.JLabel system;
    public DefaultTableModel inputQueue_model;
    public DefaultTableModel queue1_model;
    public DefaultTableModel queue2_model;
    public DefaultTableModel queue3_model;
    public DefaultTableModel queue4_model;
    public DefaultTableModel cpu_model;
    public int value;

    /**
     * This method is the default constructor for jFrame.
     */
    public JFrameExtraCredit() {
        initComponents();
        setjTableModels();
    }

    /**
     * This method creates the gui components.
     */
    private void initComponents() {	
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_inputQueue = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_Queue1 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable_Queue2 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable_Queue3 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable_Queue4 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        isBusy = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable_cpu = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        console = new javax.swing.JTextArea();
        system = new javax.swing.JLabel();
        job = new javax.swing.JLabel();
        quantum = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        speed = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable_inputQueue.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTable_inputQueue.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Input Queue"
                }
            ));
        jTable_inputQueue.setToolTipText("");
        jScrollPane4.setViewportView(jTable_inputQueue);

        jPanel1.setBackground(new java.awt.Color(51, 204, 255)); //blue

        jTable_Queue1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTable_Queue1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Queue 1"
                }
            ));
        jScrollPane3.setViewportView(jTable_Queue1);
        jTable_Queue1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jTable_Queue2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTable_Queue2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Queue 2"
                }
            ));
        jScrollPane6.setViewportView(jTable_Queue2);
        jTable_Queue2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jTable_Queue3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTable_Queue3.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Queue 3"
                }
            ));
        jScrollPane7.setViewportView(jTable_Queue3);
        jTable_Queue3.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jTable_Queue4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTable_Queue4.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Queue 4"
                }
            ));
        jScrollPane5.setViewportView(jTable_Queue4);
        jTable_Queue4.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 255, 0)); //green

        isBusy.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        isBusy.setText("CPU FREE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(isBusy)
                .addGap(67, 67, 67)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(isBusy)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTable_cpu.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTable_cpu.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                }, 
                new String [] {
                    "CPU"
                }
            ));
        jTable_cpu.setColumnSelectionAllowed(true);
        jScrollPane10.setViewportView(jTable_cpu);
        jTable_cpu.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        console.setColumns(20);
        console.setRows(5);
        jScrollPane1.setViewportView(console);

        system.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        system.setText("System Time:");

        job.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        job.setText("Job Time:");

        quantum.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        quantum.setText("Quantum Time:");

        jSlider1.setMinimum(10);
        jSlider1.setMaximum(200); // max clock
        jSlider1.setValue(10); // I set it here for speed's sake
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() 
            {
                public void stateChanged(javax.swing.event.ChangeEvent evt) {
                    jSlider1StateChanged(evt);
                }
            }
        );

        speed.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        speed.setText("speed: 100");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Multi-level Feedback Queue ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(speed, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantum, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(system, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(job, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(speed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(system)
                        .addGap(18, 18, 18)
                        .addComponent(quantum, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(job, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }                      

    /**
     * This method is the event handler for jSlider1 on GUI.
     * @param evt
     */
    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {                                      
        value = jSlider1.getValue();
        speed.setText("speed: " + value);
    } 

    /**
     * This method sets the GUI busy flag for the GUI.
     * @param status
     */
    public void setBusyFlag_GUI(boolean status) {
        if (status == true) {
            jPanel3.setBackground(new java.awt.Color(255,0,01)); //red
            isBusy.setText("CPU BUSY");
        }
        else if (status == false) {
            jPanel3.setBackground(new java.awt.Color(102, 255, 51)); //green
            isBusy.setText("CPU FREE");
        }
    }

    /**
     * This method sets the jTable models.
     */
    public void setjTableModels(){
        inputQueue_model = (DefaultTableModel) jTable_inputQueue.getModel();
        queue1_model = (DefaultTableModel) jTable_Queue1.getModel();
        queue2_model = (DefaultTableModel) jTable_Queue2.getModel();
        queue3_model = (DefaultTableModel) jTable_Queue3.getModel();
        queue4_model = (DefaultTableModel) jTable_Queue4.getModel();
        cpu_model = (DefaultTableModel) jTable_cpu.getModel();
    }
}
