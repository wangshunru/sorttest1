import java.util.Stack;

/**
 * @author wangshunxi
 * @since 2020/2/23.
 */
public class HanNuoTaTest {
    private int step = 0;
    private Item x;
    private Item y;
    private Item z;

    class Item {
        protected Stack<Integer> data;
        protected String name;

        public Stack<Integer> getData() {
            return data;
        }

        public void setData(Stack<Integer> data) {
            this.data = data;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public Item getX() {
        return x;
    }

    public void setX(Item x) {
        this.x = x;
    }

    public Item getY() {
        return y;
    }

    public void setY(Item y) {
        this.y = y;
    }

    public Item getZ() {
        return z;
    }

    public void setZ(Item z) {
        this.z = z;
    }

    public static void main(String[] args) {
        HanNuoTaTest test = new HanNuoTaTest();
        Item x = test.new Item();
        x.setData(new Stack<Integer>());
        x.setName("x");
        test.setX(x);
        Item y = test.new Item();
        y.setData(new Stack<Integer>());
        y.setName("y");
        Item z = test.new Item();
        z.setData(new Stack<Integer>());
        z.setName("z");
        // 将1 - 10 压入栈中
        int size = 4;
        for (int i = size; i >= 1; i--) {
            x.getData().push(i);
        }
        // x 中的盘子 借助 z 最后全部移到 y 不能大的放到小的上边
        test.move(x, y, z, size);
        System.out.println("总共步数:" + test.step);
    }

    private void move(Item x, Item y, Item z, int deep) {
        if (deep == 1) {
            System.out.println(x.getName() + "-->" + x.getData().peek() + "-->" + y.getName());
            y.getData().push(x.getData().pop());
            step++;
        } else {
            move(x, z, y, deep - 1);
            System.out.println(x.getName() + "-->" + x.getData().peek() + "-->" + y.getName());
            y.getData().push(x.getData().pop());
            step++;
            move(z, y, x, deep - 1);

        }
    }
}
