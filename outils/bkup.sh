#! /usr/bin/bash
# Backup cours java

echo "Archivage sélectif et horodaté de htdocs."
echo "-----------------------------------------"
 
 
if [[ -d /d/ ]]; then 
	
	# 0=date 1=heure
	if [[ $1 -eq 0 ]]; then
		today=$(date +"%F")
	else
		today=$(date +"%Y-%m-%d_%H%M%S")
	fi
	
	host='eni'
	dest="/d/ENI/05-JAVA-EE"
	cours="javaEE"
	
	#tar uvf ${dest}/bk_${host}_${cours}_${today}.tar /c/Users/rlizot2019/Downloads/git/ENI_Java
	#tar uvf ${dest}/bk_${host}_${cours}_${today}.tar /c/Users/rlizot2019/Documents/NetBeansProjects
	#tar uvf ${dest}/bk_${host}_${cours}_${today}.tar /c/Users/rlizot2019/Documents/eclipse-workspace
	#tar -C /c/Users/rlizot2019/Downloads/ -uvf ${dest}/bk_${host}_${cours}_${today}.tar git/ENI_Java
	#tar -C /c/Users/rlizot2019/Documents/ -uvf ${dest}/bk_${host}_${cours}_${today}.tar eclipse-workspace
	tar -C /c/Users/rlizot2019/Documents/ -uvf ${dest}/bk_${host}_${cours}_${today}.tar NetBeansProjects
	tar -C /c/Users/rlizot2019/Desktop/ -uvf ${dest}/bk_${host}_${cours}_${today}.tar *.sh
	tar -C /c/Users/rlizot2019/ -uvf ${dest}/bk_${host}_${cours}_${today}.tar IdeaProjects
 
	echo '---------- FIN --------------'
	echo "Archive : bk_${host}_${cours}_${today}.tar"
	#echo "/c/Users/rlizot2019/Downloads/git/ENI_Java"
	echo "/C/Users/rlizot2019/Documents/NetBeansProjects"
	#echo "/C/Users/rlizot2019/Documents/eclipse-workspace"
	echo "/c/Users/rlizot2019/IdeaProjects"
	echo '---------- FIN --------------'
 
else
	echo "Répertoire D:/ introuvable. Branchez memstick."
fi
 
sleep 3
 
