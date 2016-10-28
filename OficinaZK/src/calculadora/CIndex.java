package calculadora;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.zkoss.bind.AnnotateBinder;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zkplus.databind.DataBinder;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Listbox;

public class CIndex extends GenericForwardComposer {
	private Intbox intbxCampoSoma1;
	private Intbox intbxCampoSoma2;
	private Intbox intbxResultadoSoma;
	private int resultadoSoma;
	private DataBinder binder;
	private Listbox lstbxTeste;
	ArrayList<LinkedHashMap<String, Object>> arrayDaLista;

	/*Getter and Setter */
	public ArrayList<LinkedHashMap<String, Object>> getArrayDaLista() {
		return arrayDaLista;
	}

	public void setArrayDaLista(ArrayList<LinkedHashMap<String, Object>> arrayDaLista) {
		this.arrayDaLista = arrayDaLista;
	}

	public int getResultadoSoma() {
		return resultadoSoma;
	}

	public void setResultadoSoma(int resultadoSoma) {
		this.resultadoSoma = resultadoSoma;
	}

	/* Metodos de evento*/
	public void onClick$btnSomar() {
		this.resultadoSoma = this.intbxCampoSoma1.getValue() + this.intbxCampoSoma2.getValue();

		this.binder.loadComponent(intbxResultadoSoma);
	}

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		binder = new AnnotateDataBinder(comp);
		binder.loadAll();
	}
	public void onClick$btnConsultar() {
		this.arrayDaLista = new ArrayList<LinkedHashMap<String, Object>>();
		
		LinkedHashMap<String, Object> hash;
		
		hash = new LinkedHashMap<String,Object>();
		hash.put("dado1", 10);
		hash.put("dado2", 20);
		this.arrayDaLista.add(hash);
		
		hash = new LinkedHashMap<String,Object>();
		hash.put("dado1", 30);
		hash.put("dado2", 40);
		this.arrayDaLista.add(hash);
		
		this.binder.loadComponent(this.lstbxTeste);
		this.lstbxTeste.setVisible(true);
		
	}

}
