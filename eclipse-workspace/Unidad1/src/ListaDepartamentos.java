import java.util.ArrayList;
import java.util.List;
public class ListaDepartamentos {
private List<Departamento> lista = new ArrayList<Departamento>();
public ListaDepartamentos(){}
public void add(Departamento per){
lista.add(per);
}
public List<Departamento> getListaDepartamento(){
return lista;
}
}
