package patterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {

    List<Component> components = new ArrayList<>();

    public void addComponent(Component component)
    {
        components.add(component);
    }

    @Override
    public void printInfo() {
        System.out.println("I'm a group");
        components.forEach(Component::printInfo);
    }
}
