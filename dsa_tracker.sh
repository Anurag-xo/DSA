#!/bin/bash

# Configuration
TRACKER_FILE="PROGRESS.md"
CONFIG_FILE=".dsa_config"
BACKUP_DIR="./.progress_backups"
TODAY=$(date "+%Y-%m-%d")
WEEK_NUM=$((($(date +%-d)-1)/7+1))

# Colors
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Tips Database
TIPS=(
    "Practice recursion with tree problems first"
    "Solve at least one problem daily without looking at solutions"
    "Time complexity analysis should become second nature"
    "Revisit old problems every weekend"
    "Draw diagrams for complex data structures"
    "Master sliding window pattern for array problems"
    "Focus on pattern recognition, not memorization"
    "Do timed practice sessions to simulate interviews"
)

# Initialize
init_setup() {
    [ ! -d "$BACKUP_DIR" ] && mkdir -p "$BACKUP_DIR"
    
    if [ ! -f "$TRACKER_FILE" ]; then
        cat > "$TRACKER_FILE" << 'EOL'
# DSA Progress Tracker

## Week 1
| Day | Date       | Completed Tasks                     | Notes                 |
|-----|------------|-------------------------------------|-----------------------|
EOL
        echo -e "${GREEN}Created new tracker file!${NC}"
    fi
    
    if [ ! -f "$CONFIG_FILE" ]; then
        touch "$CONFIG_FILE"
        read -p "Enter your GitHub repo URL (optional): " gh_url
        [ -n "$gh_url" ] && echo "GITHUB_URL=$gh_url" >> "$CONFIG_FILE"
    fi
}

# GitHub Sync
github_sync() {
    source "$CONFIG_FILE" 2>/dev/null
    if [ -z "$GITHUB_URL" ]; then
        echo -e "${YELLOW}No GitHub URL configured. Use option 4 to add one.${NC}"
        return
    fi

    if ! git status &>/dev/null; then
        git init
        [ -n "$GITHUB_URL" ] && git remote add origin "$GITHUB_URL"
    fi

    git add "$TRACKER_FILE"
    git commit -m "Daily update: $(date +%F)" >/dev/null
    
    if git push -u origin main 2>/dev/null; then
        echo -e "${GREEN}✓ Synced with GitHub${NC}"
    else
        echo -e "${RED}Failed to sync with GitHub${NC}"
        echo "Try: git push -u origin main"
    fi
}

# Daily Reminder
daily_reminder() {
    echo -e "\n${BLUE}📝 Today's DSA Goals ${NC}"
    echo "1. Implement: "
    echo "2. Solve: "
    echo "3. Study: "
    echo -e "\n💡 Tip: ${TIPS[$RANDOM % ${#TIPS[@]}]}"
}

# Update Progress
update_progress() {
    echo -e "\n${BLUE}Let's update your progress!${NC}"
    
    echo -e "\n${YELLOW}Last entry:${NC}"
    tail -n 3 "$TRACKER_FILE" | head -n 1
    
    echo -e "\nWhat did you complete today? (comma separated)"
    read -p "> " progress
    
    echo -e "\nAny notes or challenges?"
    read -p "> " notes
    
    # Format progress
    formatted_progress=$(echo "$progress" | sed 's/,\s*/\n- [x] /g')
    formatted_progress="- [x] $formatted_progress"
    
    # Add new row
    echo "| $(date +%d) | $TODAY | $formatted_progress | $notes |" >> "$TRACKER_FILE"
    
    # Update metrics
    problems=$(grep -c "\[\x\] Solve" "$TRACKER_FILE" 2>/dev/null || echo 0)
    concepts=$(grep -c "\[\x\] Implement" "$TRACKER_FILE" 2>/dev/null || echo 0)
    loc=$(find src/ -name "*.java" 2>/dev/null | xargs wc -l | tail -1 | awk '{print $1}')
    
    # Create/update metrics section
    if grep -q "## Key Metrics" "$TRACKER_FILE"; then
        sed -i "/^Problems Solved:/c\Problems Solved: $problems/60" "$TRACKER_FILE"
        sed -i "/^Concepts Mastered:/c\Concepts Mastered: $concepts/12" "$TRACKER_FILE"
        sed -i "/^Lines of Java:/c\Lines of Java: ${loc:-0}" "$TRACKER_FILE"
    else
        echo -e "\n## Key Metrics" >> "$TRACKER_FILE"
        echo "- Problems Solved: $problems/60" >> "$TRACKER_FILE"
        echo "- Concepts Mastered: $concepts/12" >> "$TRACKER_FILE"
        echo "- Lines of Java: ${loc:-0}" >> "$TRACKER_FILE"
    fi
    
    echo -e "${GREEN}✓ Progress updated!${NC}"
}

# View Stats
view_stats() {
    echo -e "\n${BLUE}📊 Your Progress ${NC}"
    
    # Current week summary
    echo -e "${YELLOW}=== Week $WEEK_NUM Summary ===${NC}"
    grep -A5 "## Week $WEEK_NUM" "$TRACKER_FILE" | grep -v "##" | awk -F'|' '{printf " %-12s %s\n", $2, $3}' | tail -n +2 | sed '/^$/d'
    
    # Metrics
    echo -e "\n${YELLOW}📈 Metrics:${NC}"
    grep -A3 "## Key Metrics" "$TRACKER_FILE" 2>/dev/null || echo "No metrics yet"
    
    # Progress bars
    problems=$(grep "Problems Solved:" "$TRACKER_FILE" 2>/dev/null | awk '{print $3}' | cut -d'/' -f1)
    total_problems=60
    concepts=$(grep "Concepts Mastered:" "$TRACKER_FILE" 2>/dev/null | awk '{print $3}' | cut -d'/' -f1)
    total_concepts=12

    echo -e "\n${YELLOW}📅 Completion:${NC}"
    echo -n "Problems: "
    print_progress_bar "${problems:-0}" "${total_problems:-60}"
    echo -n "Concepts: "
    print_progress_bar "${concepts:-0}" "${total_concepts:-12}"
}

print_progress_bar() {
    local current=${1:-0}
    local total=${2:-60}
    
    # Handle invalid inputs
    if ! [[ "$current" =~ ^[0-9]+$ ]] || ! [[ "$total" =~ ^[0-9]+$ ]]; then
        printf "[                    ] 0/%d (0%%)\n" "$total"
        return
    fi
    
    if [ "$total" -eq 0 ]; then
        total=1
    fi
    
    local filled=$(( current * 20 / total ))
    local empty=$(( 20 - filled ))
    
    printf "["
    printf "%${filled}s" | tr ' ' '#'
    printf "%${empty}s" | tr ' ' ' '
    printf "] %d/%d (%.0f%%)\n" "$current" "$total" "$(echo "scale=2; $current*100/$total" | bc)"
}

# Main Menu
main_menu() {
    while true; do
        echo -e "\n${BLUE}🚀 DSA Tracker ${NC}"
        echo "1. Update progress"
        echo "2. View stats"
        echo "3. GitHub sync"
        echo "4. Setup/config"
        echo "5. Exit"
        
        read -p "Choose (1-5): " choice
        
        case $choice in
            1) update_progress;;
            2) view_stats;;
            3) github_sync;;
            4) nano "$CONFIG_FILE";;
            5) exit 0;;
            *) echo -e "${RED}Invalid option!${NC}";;
        esac
        
        read -p "Press Enter to continue..."
        clear
    done
}

# Run
init_setup
daily_reminder
main_menu
