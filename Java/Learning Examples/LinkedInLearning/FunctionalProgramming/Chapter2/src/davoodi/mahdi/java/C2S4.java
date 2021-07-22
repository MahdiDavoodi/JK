package davoodi.mahdi.java;

/*
 * A simple example to control the functions like variables and data in runtime.
 * I don't get the point tho. We can do this without functional programming.*/
public class C2S4 {
    protected static class DataLoader {
        // Use custom function interface for functions with no args.
        public final MyNoArgFunction<Boolean> function;

        public DataLoader(boolean isDevelopmentTest) {
            this.function = isDevelopmentTest ? this::loadSampleData
                    : this::loadRealData;
        }

        private boolean loadRealData() {
            System.out.println("This is Real Data ...");
            return true;
        }

        private boolean loadSampleData() {
            System.out.println("This is sample data ...");
            return true;
        }
    }

    public static void main(String[] args) {
        // We can choose which function we want to run.
        DataLoader loader = new DataLoader(false);
        loader.function.apply();
    }
}
