class Node:
  def __init__(self, val):
    self.val = val
    self.next = None

def find_middle_node(head):
	fast = head
  slow = head
  while fast and fast.next:
  	slow = slow.next
      fast = fast.next.next
  return slow

# Helper function to build linked list from a list
def build_linked_list(values):
  head = Node(values[0])
  current = head
  for val in values[1:]:
    current.next = Node(val)
    current = current.next
  return head

# Helper function to print linked list
def print_linked_list(head):
  while head
    print(head.val, end=" -> " if head.next else "\n")
    head = head.next

# Test input
values = [1, 2, 3, 4, 5, 6]
head = build_linked_list(values)

print("Original Linked List:")
print_linked_list(head)

# Find and print the middle node



middle = find_middle_node(head)
print("Middle Node Value:", middle.val) 