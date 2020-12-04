package testrunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestRunnerBase {
    public List<String> data;
    public List<HashMap<String,Object>> steps;
    private int index=-1;

    public void caseGengenerate(){
        List<TestRunnerBase> list=new ArrayList<TestRunnerBase>();
        for(int i=0;i<data.size();i++){
            TestRunnerBase testRunnerBase=new TestRunnerBase();
            testRunnerBase.index=i;
            testRunnerBase.steps=steps;
            testRunnerBase.data=data;
            list.add(testRunnerBase);
        }
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
