import java.util.*;

public class Main {
    // 이미 알고 있는지에 대해서 판단을 위해 필요
    static boolean[] knowMembers;
    static int N, M;
    // 연결된 사람들을 전부 집어넣기 위한 정보 기록
    static Map<Integer, Set<Integer>> connectedMembersMap = new HashMap<>();
    // 파티 정보 -> 연결하기 위해서 필요
    static List<Party> parties = new ArrayList<>();
    // 처음에 알고있는 사람들
    static List<Integer> knowMemberList = new ArrayList<>();

    public static void main(String[] args) {
        initialize();
        findKnowMembers();
        System.out.println(solve());
    }

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        String[] sizeInput = sc.nextLine().split(" ");
        N = Integer.parseInt(sizeInput[0]);
        M = Integer.parseInt(sizeInput[1]);
        knowMembers = new boolean[N + 1];

        String[] knowInput = sc.nextLine().split(" ");
        for (int i = 1; i < knowInput.length; i++) {
            knowMemberList.add(Integer.parseInt(knowInput[i]));
        }

        for (int i = 1; i <= N; i++) {
            connectedMembersMap.put(i, new HashSet<>());
        }

        for (int i = 0; i < M; i++) {
            String[] partyInput = sc.nextLine().split(" ");
            int partyMembersCnt = Integer.parseInt(partyInput[0]);
            int[] members = new int[partyMembersCnt];

            for (int j = 1; j < partyInput.length; j++) {
                members[j - 1] = Integer.parseInt(partyInput[j]);
            }

            putParty(members);
        }
    }

    public static void findKnowMembers() {
        Queue<Integer> queue = new LinkedList<>();

        for (int know : knowMemberList) {
            //시작을 여기서 하는것, dfs
            queue.add(know);

            while (!queue.isEmpty()) {
                int member = queue.poll();
                if (knowMembers[member]) continue;
                knowMembers[member] = true;
                Set<Integer> connectedMembers = connectedMembersMap.get(member);
                for (int c : connectedMembers) {
                    queue.add(c);
                }
            }
        }
    }

    public static int solve() {
        int result = 0;
        for (Party party : parties) {
            if (canLie(party)) result++;
        }
        return result;
    }

    public static boolean canLie(Party party) {
        for (int member : party.partyMembers) {
            if (knowMembers[member]) return false;
        }
        return true;
    }

    public static void putParty(int[] members) {
        parties.add(new Party(members));

        for (int member : members) {
            Set<Integer> connectedMembers = connectedMembersMap.get(member);
            for (int m : members) {
                connectedMembers.add(m);
            }
            connectedMembersMap.put(member, connectedMembers);
        }
    }

    static class Party {
        Set<Integer> partyMembers = new HashSet<>();

        public Party(int[] members) {
            for (int member : members) {
                partyMembers.add(member);
            }
        }
    }
}
