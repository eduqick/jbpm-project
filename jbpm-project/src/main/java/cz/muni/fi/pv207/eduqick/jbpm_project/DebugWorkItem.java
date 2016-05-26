package cz.muni.fi.pv207.eduqick.jbpm_project;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

public class DebugWorkItem implements WorkItemHandler {

    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        System.out.println("---------------------------------debug-----------------------------------------");
        for (String key : workItem.getParameters().keySet()) {
            System.out.println("param '" + key + "' => " + workItem.getParameter(key));
        }

        System.out.println("");
        System.out.println("results: " + workItem.getResults());
        System.out.println("-------------------------------------------------------------------------------");

        workItemManager.completeWorkItem(workItem.getId(), workItem.getResults());
    }

    public void abortWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        System.out.println("aborting work item - by doing nothing :D");
    }

}
