package Controlador;

import Visual.Menu;
import Visual.MedicoForm;
import Visual.PacienteForm;
import Visual.FarmaciaForm;

public class MenuControlador {
    private Menu menu;

    public MenuControlador(Menu menu) {
        this.menu = menu;
        menu.btnMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirFormularioMedico();
            }
        });
        menu.btnPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirFormularioPaciente();
            }
        });
        menu.btnFarmacia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirFormularioFarmacia();
            }
        });
    }

    private void abrirFormularioMedico() {
        MedicoForm formularioMedico = new MedicoForm();
        formularioMedico.setVisible(true);
    }

    private void abrirFormularioPaciente() {
        PacienteForm formularioPaciente = new PacienteForm();
        formularioPaciente.setVisible(true);
    }

    private void abrirFormularioFarmacia() {
        FarmaciaForm formularioFarmacia = new FarmaciaForm();
        formularioFarmacia.setVisible(true);
    }
}
