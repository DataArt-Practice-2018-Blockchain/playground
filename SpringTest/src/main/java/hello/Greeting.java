package hello;

public class Greeting {

    private final long num;

    public long getNum() {
        return num;
    }

    public String getText() {
        return text;
    }

    private final String text;

    public Greeting(long num, String text) {
        this.num = num;
        this.text = text;
    }

    private final static String template = "<h1>Hello for the %s time, %s!</h1>";

    private static String postfixedNum(long num) {
        String postfix;
        switch ((int)(num % 10)) {
            case 1: {
                postfix = "st";
                break;
            }
            case 2: {
                postfix = "nd";
                break;
            }
            case 3: {
                postfix = "rd";
                break;
            }
            default: {
                postfix = "th";
            }
        }
        return Long.toString(num) + postfix;
    }

    public String toHTML() {
        return String.format(template, postfixedNum(num), text);
    }
}
