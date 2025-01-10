class Solution {
public long solution(int cap, int n, int[] deliveries, int[] pickups) {
    int maxDeliver = cap;
    int maxPickup = cap;
    long dist = 0;

    int farthestDelivery = deliveries.length;
    int farthestPickup = pickups.length;

    while (true) {
        // 가장 먼 배달 및 수거 위치 계산 (이전 값과 비교)
        for (int i = farthestDelivery - 1; i >= 0; i--) {
            if (deliveries[i] > 0) {
                farthestDelivery = i + 1;
                break;
            }
            farthestDelivery = 0; // 더 이상 배달이 없으면 0으로 설정
        }

        for (int i = farthestPickup - 1; i >= 0; i--) {
            if (pickups[i] > 0) {
                farthestPickup = i + 1;
                break;
            }
            farthestPickup = 0; // 더 이상 수거가 없으면 0으로 설정
        }

        // 종료 조건: 배달과 수거가 모두 끝난 경우
        if (farthestDelivery == 0 && farthestPickup == 0) {
            break;
        }

        // 이동 거리 추가 (왕복 거리)
        dist += Math.max(farthestDelivery, farthestPickup) * 2;

        // 배달 처리
        int deliverIndex = farthestDelivery;
        while (deliverIndex > 0 && maxDeliver > 0) {
            maxDeliver = doProcess(maxDeliver, deliveries, deliverIndex--);
        }

        // 수거 처리
        int pickupIndex = farthestPickup;
        while (pickupIndex > 0 && maxPickup > 0) {
            maxPickup = doProcess(maxPickup, pickups, pickupIndex--);
        }

        // 용량 초기화
        maxDeliver = cap;
        maxPickup = cap;
    }

    return dist;
}

public int doProcess(int maxProcess, int[] processHouse, int index) {
    if(maxProcess == 0 || index == 0){
        return maxProcess;
    }
    if (maxProcess > processHouse[index - 1]) {
        maxProcess -= processHouse[index - 1];
        processHouse[index - 1] = 0;
    } else {
        processHouse[index - 1] -= maxProcess;
        maxProcess = 0;
    }
    return maxProcess;
}
}
