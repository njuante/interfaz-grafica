package Puerto;

public class Hub {
    Contenedor[][] puerto = new Contenedor[10][12];

    public Hub(){}
    public Hub(Contenedor[][] puerto){
        if(puerto!=null) this.puerto=puerto;
    }

    public String toString(){
        String plano = new String();
        for (int i = 0; i < puerto.length; i++) {
            for (int j = 0; j < puerto[i].length; j++) {
                if(puerto[i][j]!=null) plano+= "[O]";
                else plano+="[L]";
            }
            plano+="\n";
        }
        return plano;
    }

    public void apilar(Contenedor contenedor){
        if(contenedor!=null) {
            if (contenedor.getPrio() == 1 || contenedor.getPrio() == 2) {
                int colum=contenedor.getPrio()-1;
                if (contenedor.getPrio() == 1) {
                    for (int i = puerto.length-1; i > -1; --i) {
                        if (puerto[i][colum] == null) {
                            puerto[i][colum] = contenedor;
                            return;
                        }
                    }
                }
            }
            else{
                for (int i = 2; i < puerto[0].length ; --i) {
                    for (int j = puerto.length-1; j > -1; --j) {
                        if(puerto[i][j]==null){
                            puerto[i][j]=contenedor;
                            return;
                        }
                    }
                }
            }
        }
    }

    public void desapilar(int colum){
        if(colum<0 || colum>=puerto.length) return;
        for (int i = 0; i < puerto.length; i++) {
            if(puerto[i][colum]!=null){
                Contenedor vacio = puerto[i][colum];
                return;
            }
        }
        return;
    }

    public void contenedor(int id){
        for (int i = 0; i < puerto.length; i++) {
            for (int j = 0; j < puerto[0].length; j++) {
                if(puerto[i][j].getId()==id){
                    puerto[i][j].toString();
                    return;
                }
            }
        }
        System.out.println("No  existe un contendor con dicho ID en el puerto");
    }

    public int npais(String procedencia){
        int s=0;
        for (int i = 0; i < puerto.length; i++) {
            for (int j = 0; j < puerto[0].length; j++) {
                if(procedencia.equals(puerto[i][j].getProcedencia())) ++s;
            }
        }
        return s;
    }
}
