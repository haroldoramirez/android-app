package br.org.itai.agenda;

import android.widget.EditText;
import android.widget.RatingBar;

import br.org.itai.agenda.modelo.Contato;

/**
 * Created by haroldo on 13/11/15.
 */
public class FormularioHelper {

    private final EditText campoNome;
    private final EditText campoTelefone;
    private final EditText campoEmail;
    private final EditText campoEndereco;
    private final RatingBar campoNota;

    private Contato contato;


    public FormularioHelper(FormularioActivity activity) {
        campoNome = (EditText) activity.findViewById(R.id.formulario_nome);
        campoTelefone = (EditText) activity.findViewById(R.id.formulario_telefone);
        campoEmail = (EditText) activity.findViewById(R.id.formulario_email);
        campoEndereco = (EditText) activity.findViewById(R.id.formulario_endereco);
        campoNota = (RatingBar) activity.findViewById(R.id.formulario_nota);

        contato = new Contato();
    }

    public Contato pegaContato() {
        contato.setNome(campoNome.getText().toString());
        contato.setTelefone(campoTelefone.getText().toString());
        contato.setEmail(campoEmail.getText().toString());
        contato.setEndereco(campoEndereco.getText().toString());
        contato.setNota(Double.valueOf(campoNota.getProgress()));

        return contato;
    }

    public void preencheFormulario(Contato contato) {
        campoNome.setText(contato.getNome());
        campoTelefone.setText(contato.getTelefone());
        campoEmail.setText(contato.getEmail());
        campoEndereco.setText(contato.getEndereco());
        campoNota.setProgress(contato.getNota().intValue());

        this.contato = contato;
    }
}
