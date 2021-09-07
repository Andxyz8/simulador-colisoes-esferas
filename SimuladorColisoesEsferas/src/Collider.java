import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Collider extends JFrame {
    static int n;

    public Collider(int w, int h, int n) {
        initComponents();

        Collider.n = n;
        this.setSize(w, h);
        this.setResizable(false);

        jLabel_BallCount.setText(Integer.toString(Rinha.getNumBall()));

        this.setVisible(true);
    }

    public void iniciar() {
        Rinha.createBalls();
        Rinha.start();
    }

    private void initComponents() {
        Rinha = new Arena();
        jButton_Start = new javax.swing.JButton();
        jButton_Stop = new javax.swing.JButton();
        jButton_RemBall = new javax.swing.JButton();
        jButton_AddBall = new javax.swing.JButton();
        jLabel_BallCount = new javax.swing.JLabel();
        jLabel_ArenaTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ball Collider Simulator 2021");
        setName("Collisor"); // NOI18N

        Rinha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51), 3));
        Rinha.setName("Arena"); // NOI18N
        Rinha.setPreferredSize(new java.awt.Dimension(780, 342));
        Rinha.setNumBall(n);

        javax.swing.GroupLayout jPanel_ArenaLayout = new javax.swing.GroupLayout(Rinha);
        Rinha.setLayout(jPanel_ArenaLayout);
        jPanel_ArenaLayout.setHorizontalGroup(jPanel_ArenaLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));
        jPanel_ArenaLayout.setVerticalGroup(jPanel_ArenaLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 359, Short.MAX_VALUE));

        jButton_Start.setText("Start");
        jButton_Start.setToolTipText("Start colisions with 2 balls");
        jButton_Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_StartActionPerformed(evt);
            }
        });

        jButton_Stop.setText("Stop");
        jButton_Stop.setToolTipText("Stop ALL balls");
        jButton_Stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_StopActionPerformed(evt);
            }
        });

        jButton_RemBall.setText("Rem Ball");
        jButton_RemBall.setToolTipText("Remove a ball");
        jButton_RemBall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RemBallActionPerformed(evt);
            }
        });

        jButton_AddBall.setText("Add Ball");
        jButton_AddBall.setToolTipText("Add a ball");
        jButton_AddBall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddBallActionPerformed(evt);
            }
        });

        jLabel_BallCount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_BallCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_BallCount.setText("0");
        jLabel_BallCount.setAlignmentX(0.5F);
        jLabel_BallCount.setBorder(javax.swing.BorderFactory.createTitledBorder(
                javax.swing.BorderFactory.createEtchedBorder(), "Ball Count", javax.swing.border.TitledBorder.LEFT,
                javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel_ArenaTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_ArenaTitle.setText("Collision Arena");
        jLabel_ArenaTitle.setToolTipText("This is just a title");
        jLabel_ArenaTitle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(12, 12, 12)
                        .addComponent(Rinha, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                .addGroup(layout.createSequentialGroup().addContainerGap(110, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton_Start, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_Stop, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_BallCount, javax.swing.GroupLayout.PREFERRED_SIZE, 151,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton_AddBall, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton_RemBall, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(110, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_ArenaTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 170,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                layout.createSequentialGroup().addContainerGap()
                                        .addComponent(jLabel_ArenaTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Rinha, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup().addComponent(jButton_Start)
                                                        .addGap(18, 18, 18).addComponent(jButton_Stop))
                                                .addComponent(jLabel_BallCount)
                                                .addGroup(layout.createSequentialGroup().addComponent(jButton_AddBall)
                                                        .addGap(18, 18, 18).addComponent(jButton_RemBall)))
                                        .addGap(5, 5, 5)));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_StopActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton_StopActionPerformed
        Rinha.stop();
    }// GEN-LAST:event_jButton_StopActionPerformed

    private void jButton_StartActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton_StartActionPerformed
        Rinha.start();
    }// GEN-LAST:event_jButton_StartActionPerformed

    private void jButton_AddBallActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton_AddBallActionPerformed
        Rinha.addBall();
        jLabel_BallCount.setText(Integer.toString(Rinha.getNumBall()));
    }// GEN-LAST:event_jButton_AddBallActionPerformed

    private void jButton_RemBallActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton_RemBallActionPerformed
        Rinha.remBall();
        jLabel_BallCount.setText(Integer.toString(Rinha.getNumBall()));
    }// GEN-LAST:event_jButton_RemBallActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton jButton_AddBall;
    private JButton jButton_RemBall;
    private JButton jButton_Start;
    private JButton jButton_Stop;
    private JLabel jLabel_ArenaTitle;
    private JLabel jLabel_BallCount;
    Arena Rinha;
}
