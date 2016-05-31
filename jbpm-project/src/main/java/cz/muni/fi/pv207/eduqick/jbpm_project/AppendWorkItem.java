package cz.muni.fi.pv207.eduqick.jbpm_project;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In parameters
 * <ul>
 * <li>List - optional - collection to append to (will be created if none).</li> 
 * <li>Entry - entry to add to collection (will be ignored if none).</li>
 * </ul>
 * Out parameters
 * <ul>
 * <li>List - collection with appended Entry</li>
 * </ul>
 * @author jludvice
 *
 */
public class AppendWorkItem implements WorkItemHandler {

    public static final String LIST = "List";
    public static final String ENTRY = "Entry";

    public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
        System.out.println("Aborting " + AppendWorkItem.class.getName() + " by doing nothing :).");
    }

    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
        List list;
        Object inList = workItem.getParameter(LIST);
        if (inList == null) {
            list = new ArrayList();
        } else {
            list = (List) inList;
        }

        Object entry = workItem.getParameter(ENTRY);
        if (entry != null) {
            list.add(entry);
        } else {
            System.out.println("parameter " + ENTRY + " was null");
        }

        Map<String, Object> results = new HashMap<String, Object>();
        results.put(LIST, list);

        manager.completeWorkItem(workItem.getId(), results);

    }

}
