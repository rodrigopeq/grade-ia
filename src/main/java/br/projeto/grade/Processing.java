package br.projeto.grade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import br.projeto.models.Disciplina;

public class Processing {
	
	private LinkedHashMap<String,Disciplina> mapResult;
	
	Processing(LinkedHashMap<String, Disciplina> mapResult){
		this.mapResult = mapResult;
	}

	public LinkedHashMap<String,Disciplina> getMapResult() {
		return mapResult;
	}

	public void setMapResult(LinkedHashMap<String,Disciplina> mapResult) {
		this.mapResult = mapResult;
	}
	
	public List<String> getHorarios() {
        return new ArrayList<>(mapResult.keySet());
    }
	
	public Collection<Disciplina> getDisciplinas() {
        return mapResult.values();
    }

    public Disciplina getDisciplina(String var) {
        return mapResult.get(var);
    }

    public Disciplina add(String var, Disciplina value) {
        assert value != null;
        return mapResult.put(var, value);
    }

    public Disciplina remove(String var) {
        return mapResult.remove(var);
    }

    public boolean contains(String var) {
        return mapResult.containsKey(var);
    }
    
}
