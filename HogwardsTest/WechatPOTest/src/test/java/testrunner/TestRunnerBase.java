package testrunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestRunnerBase {
    public List<String> data;
    public List<HashMap<String,Object>> steps;
    public int index=-1;

    public List<TestRunnerBase>  caseGengenerate(){
        List<TestRunnerBase> list=new ArrayList<TestRunnerBase>();
        for(int i=0;i<data.size();i++){
            MainTestRunner testRunnerBase=new MainTestRunner();
            testRunnerBase.index=i;
            testRunnerBase.steps=steps;
            testRunnerBase.data=data;
            list.add(testRunnerBase);
        }
        return list;
    }
    public Object getValue(HashMap<String,Object> step,String key){
        Object value=step.get(key);
        if(value instanceof String){
            value=((String) value).replace("${data}",data.get(index));
        }
        return value;

    }
    public void run(){

    }

}
