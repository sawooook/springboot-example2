package hello.core.NewOrder;

public interface NewOrderService {
    NewOrder createdOrder(Long memberId, String orderName, int price);
}
