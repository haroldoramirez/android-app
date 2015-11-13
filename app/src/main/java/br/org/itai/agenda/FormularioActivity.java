package br.org.itai.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import br.org.itai.agenda.dao.ContatoDAO;
import br.org.itai.agenda.modelo.Contato;

/**
 * Created by haroldo on 13/11/15.
 */
public class FormularioActivity extends AppCompatActivity {


    private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        Intent intent = getIntent();
        Contato contato = (Contato) intent.getSerializableExtra("contato");

        helper = new FormularioHelper(this);

        if (contato != null) {
            helper.preencheFormulario(contato);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_formulario_ok:
                Contato contato = helper.pegaContato();
                ContatoDAO dao = new ContatoDAO(this);
                if (contato.getId() != null) {
                    dao.altera(contato);
                } else {
                    dao.insere(contato);
                }
                dao.close();

                Toast.makeText(FormularioActivity.this, "Contato " + contato.getNome() + " salvo!", Toast.LENGTH_SHORT).show();

                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
