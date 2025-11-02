import Adapter.Action;
import Adapter.Adapter;
import Adapter.Runnable;
import Adapter.Printer;

void main() {
    Runnable printer = new Printer();
    Action action = new Adapter(printer);

    // Наш main работает теперь с Action, но под капотом все еще обьект Runnable
    action.doStuff();
}