import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    class Node{

        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Integer findValueRec(int value, Node root){

        if (root == null) return null;

        if (root.value < value){
            return findValue(value, root.right);
        }

        return findValue(value, root.left);

    }


    public Integer findValue(int value, Node root){

        if (root == null) return null;

        Node curNode = root;
        while (curNode != null){

            if (curNode.value == value) return value;
            if (curNode.value < value){
                curNode = curNode.right;
            }else {
                curNode = curNode.left;
            }
        }

        return null;
    }

    public HashMap<String, List<String>> mergeEmails(List<List<String>> emailList){

        HashMap<String, String> owners = new HashMap<>();

        HashMap<String, List<String>> emails = new HashMap<>();

        for (List<String> list : emailList){

            String owner = list.remove(0);
            emails.put(owner, new LinkedList<>());

            for (String email : list){
                if (owners.containsKey(email)){
                    if (owners.get(email).equals(owner)) continue;
                    List<String> joinEmails = emails.remove(owners.get(email));
                    emails.get(owner).addAll(joinEmails);
                    for (String jEmail : joinEmails){
                        owners.put(jEmail, owner);
                    }
                }else {
                   emails.get(owner).add(email);
                   owners.put(email, owner);
                }
            }
        }

        return emails;
    }

}
