public class CustomAutoPolicyApp {
    public static void main(String[] args) {
        CustomAutoPolicy policy1 = new CustomAutoPolicy(11111111, "Toyota Camry", "NJ");
        CustomAutoPolicy policy2 = new CustomAutoPolicy(22222222, "Ford Fusion", "ME");

        policyInNoFaultState(policy1);
        policyInNoFaultState(policy2);
    }

    public static void policyInNoFaultState(CustomAutoPolicy policy) {
        System.out.println("The auto policy:");
        System.out.printf("Account #: %d; Car: %s;%nState %s %s a no-fault state%n%n",
                policy.getAccountNumber(), policy.getMakeAndModel(), policy.getState(),
                (policy.isNoFaultState() ? "is": "is not"));
    }
}
