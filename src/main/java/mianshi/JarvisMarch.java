package mianshi;

import java.util.*;

/**
 * @author wangshunxi
 * @since 2020/3/15.
 * 凸包的构造 计算几何边界
 */
public class JarvisMarch {

    class Point {
        double x;
        double y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {
        JarvisMarch jarvisMarch = new JarvisMarch();
        Point[] data = jarvisMarch.getData();
        List<Point> result = jarvisMarch.findConvexHull(data);
        System.out.println(result.size());
    }

    private List<Point> findConvexHull(Point[] points) {
        // 找到x最小的点作为起始点
        Point start = findStartPoint(points);
        // 当前起点
        Point current = start;
        // 使用List存储边界结构
        HashSet<Point> result = new HashSet<Point>();
        result.add(start);
        // 左侧点集合 可能多个点在一条直线上
        List<Point> collinearPoints = new ArrayList<Point>();
        // 循环
        while (true) {
            // 下个目标点
            Point nextTarget = points[0];
            for (int i = 1; i < points.length; i++) {
                // 如果是当前点则跳过
                if (points[i] == current) {
                    continue;
                }
                // 计算当前起点，起始点，被匹配的目标点 之间的关系
                double val = cross(current, nextTarget, points[i]);
                if (val > 0) {
                    // 是一个左侧的点
                    nextTarget = points[i];
                    // 重置集合 因为我找到了新的左边的点
                    collinearPoints = new ArrayList<Point>();
                } else if (val == 0) {
                    // 三个点在一条直线 取距离最近的点 将远的点作为下一个目标点
                    double distance = distance(current, nextTarget, points[i]);
                    if (distance < 0) {
                        collinearPoints.add(nextTarget);
                        nextTarget = points[i];
                    } else {
                        collinearPoints.add(points[i]);
                    }
                }
            }
            for (Point p : collinearPoints) {
                result.add(p);
            }
            // 终止条件为 下个目标点为起始点 形成一个闭环结束
            if (nextTarget == start) {
                break;
            }
            // 将目标点放到集合中
            result.add(nextTarget);
            current = nextTarget;
        }
        return new ArrayList(result);
    }

    /**
     * val < 0 b距离a近
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    private double distance(Point a, Point b, Point c) {
        double x1 = a.x - b.x;
        double y1 = a.y - b.y;
        double x2 = a.x - c.x;
        double y2 = a.y - c.y;
        return x1 * x1 + y1 * y1 - (x2 * x2 + y2 * y2);
    }

    /**
     * val > 0 c
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    private double cross(Point a, Point b, Point c) {
        double x1 = a.x - b.x;
        double y1 = a.y - b.y;
        double x2 = a.x - c.x;
        double y2 = a.y - c.y;
        return y2*x1 - y1*x2;
    }

    private Point findStartPoint(Point[] points) {
        Point start = points[0];
        for (int i = 1; i < points.length; i++) {
            if (start.x > points[i].x) {
                start = points[i];
            } else if (start.x == points[i].x) {
                if (start.y > points[i].y) {
                    start = points[i];
                }
            }
        }
        return start;
    }

    private Point[] getData() {
        Point[] points = new Point[10000];
        Random random = new Random(10000);
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point((int)(random.nextDouble()*100), (int)(random.nextDouble()*100));

        }
        return points;
    }


}
