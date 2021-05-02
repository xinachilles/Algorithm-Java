import java.util.Stack;

class BrowserHistory {
Stack<String> histroy;
Stack<String> feature;
    public BrowserHistory(String homepage) {
        histroy  = new Stack<>();
        histroy.push(homepage);
        feature = new Stack<>();
    }

    public void visit(String url) {
        histroy.push(url);
        feature= new Stack<>();
    }

    public String back(int steps) {
        while (histroy.size()>1 && steps>0){
            feature.push(histroy.pop());
            steps--;
        }
        return histroy.peek();
    }

    public String forward(int steps) {
        while (feature.size()>0 && steps>0){
            histroy.push(feature.pop());
            steps--;
        }
        return histroy.peek();
    }
}
