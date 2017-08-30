package PriorityPackage;
import java.util.ArrayList;

/**
 * Created by Martin on 27-07-2017.
 */
public class MyPriorityQueue implements MyPriorityAbstraction
{
    ArrayList<Patient> list = new ArrayList<>();

    @Override
    public void insert(Object object)
    {
        if(object instanceof Patient){
            Patient newPatient = (Patient) object;

            list.add(newPatient);
            System.out.println(newPatient.getName() + ":    Has been added");
            if(list.size() > 1){
                for(int i = 0; i < list.size()-1; i++){
                    if(list.get(list.indexOf(newPatient)).getUrgencyFactor() > list.get(list.indexOf(newPatient)-1).getUrgencyFactor()){
                            int place = list.indexOf(newPatient);
                            list.set(list.indexOf(newPatient), list.get(list.indexOf(newPatient) - 1));
                            list.set(place - 1, newPatient);

                    }
                }
            }
        }
        else{
            System.out.println("SOMETHING WENT WRONG, CRASH");
        }
    }

    @Override
    public Object pull()
    {
        Patient patient = list.get(0);

        list.remove(0);
        list.trimToSize();

        return patient;
    }

    public String listToString(){
        String sentence = "";

        for(Patient patient : list){
            sentence += patient.getName() + ": " + patient.getUrgencyFactor() + ", ";
        }

        return sentence;
    }
}
