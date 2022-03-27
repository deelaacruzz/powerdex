package com.example.powerdex.menu.infoHeroe

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.powerdex.R
import com.example.powerdex.base.BaseFragment
import com.example.powerdex.databinding.ViewInfoHeroFragmentBinding

class InfoHeroFragment :
    BaseFragment<ViewInfoHeroFragmentBinding>(R.layout.view_info_hero_fragment) {

    private lateinit var binding: ViewInfoHeroFragmentBinding
    private lateinit var infoHeroViewModel: InfoHeroViewModel
    override fun ViewInfoHeroFragmentBinding.initialize() {
        binding = this
        setUpViewModel()
    }


    /**
     * Inicializa el ViewModel
     */
    private fun setUpViewModel() {
        infoHeroViewModel = ViewModelProvider(this).get(InfoHeroViewModel::class.java)
        infoHeroViewModel.getHero().observe(this, Observer { hero ->

            binding.tvName.text = hero.name
            Glide.with(requireContext()).load(hero.image.url).into(binding.ivImage)

            binding.pbIntelligence.progress = hero.powerstats.intelligence.toInt()
            binding.pbStrength.progress = hero.powerstats.strength.toInt()
            binding.pbSpeed.progress = hero.powerstats.speed.toInt()
            binding.pbDurability.progress = hero.powerstats.durability.toInt()
            binding.pbPower.progress = hero.powerstats.power.toInt()
            binding.pbCombat.progress = hero.powerstats.combat.toInt()

            binding.tvFullname.text = hero.biography.fullName
            binding.tvAlter.text = hero.biography.alterEgos
            binding.tvAliases.text =
                if (hero.biography.aliases.size > 0) hero.biography.aliases[0] else ""
            binding.tvBirth.text = hero.biography.placeOfBirth
            binding.tvFirtsAparance.text = hero.biography.firstAppearance
            binding.tvPublisher.text = hero.biography.publisher
            binding.tvAlignment.text = hero.biography.alignment


            binding.tvGender.text = hero.appearance.gender
            binding.tvRace.text = hero.appearance.race
            binding.tvHeight.text = hero.appearance.height[1]
            binding.tvWeight.text = hero.appearance.weight[1]
            binding.tvEye.text = hero.appearance.eyeColor
            binding.tvHair.text = hero.appearance.hairColor

            binding.tvOcupation.text = hero.work.occupation
            binding.tvBase.text = hero.work.base

            binding.tvAffiliates.text = hero.connections.groupAffiliation
            binding.tvRelatives.text = hero.connections.relatives
        })

    }

}