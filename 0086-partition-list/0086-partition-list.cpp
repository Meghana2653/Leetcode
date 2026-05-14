/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:

    ListNode* partition(ListNode* head, int x) {

        ListNode* smaller = new ListNode(0);
        ListNode* greater = new ListNode(0);

        ListNode* small = smaller;
        ListNode* large = greater;

        while (head != NULL) {

            if (head->val < x) {

                small->next = head;
                small = small->next;
            }
            else {

                large->next = head;
                large = large->next;
            }

            head = head->next;
        }

        large->next = NULL;

        small->next = greater->next;

        return smaller->next;
    }
};